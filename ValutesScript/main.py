from ApiRequests.BankAPI.NBRBbank import NBRBbank
from ApiRequests.BankAPI.NBTbank import NBTbank
from ApiRequests.BankAPI.CBRbank import CBRbank
from ApiRequests.BankAPI.NBUbank import NBUbank
from ApiRequests.BankAPI.NBKRbank import NBKRbank
from ApiRequests.BankAPI.KZbank import KZbank
from ApiRequests.BankAPI.CBAbank import CBAbank



nbrbBank = NBRBbank()
nbrBank = NBTbank()
cbrBank = CBRbank()
nbuBank = NBUbank()
nbkrBank = NBKRbank()
kzBank = KZbank()
cbaBank = CBAbank()


nbrbBank.Actions()
nbrBank.Actions()
cbrBank.Actions()
nbuBank.Actions()
nbkrBank.Actions()
kzBank.Actions()
